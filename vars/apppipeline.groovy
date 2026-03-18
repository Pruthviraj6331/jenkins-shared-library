
def call() {

    pipeline {

        agent any

        stages {

            stage('Build') {
                steps {
                    echo "Building Node.js App"
                    sh 'docker build -t node-app .'

                    echo "Building NGINX App"
                    sh 'docker build -t nginx-app -f Dockerfile.nginx .'
                }
            }

            stage('Test') {
                steps {
                    echo "Testing Node.js App"

                    sh '''
                    # Run temporary container for testing
                    docker rm -f test-container || true
                    docker run -d -p 3001:3000 --name test-container node-app

                    sleep 5

                    # Test using curl
                    curl -f http://localhost:3001 || exit 1

                    echo "Test Passed ✅"

                    docker rm -f test-container
                    '''
                }
            }

            stage('Deploy') {
                steps {
                    echo "Deploying Applications"

                    sh '''
                    # Remove old containers
                    docker rm -f node-container || true
                    docker rm -f nginx-container || true

                    # Run Node.js App
                    docker run -d -p 3000:3000 --name node-container node-app

                    # Run NGINX App
                    docker run -d -p 8080:80 --name nginx-container nginx-app
                    '''
                }
            }

        }
    }
}
