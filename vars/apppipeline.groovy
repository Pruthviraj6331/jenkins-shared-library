def call() {

    pipeline {

        agent any

        stages {

            stage('Build') {
                steps {
                    echo "Building application"
                    sh 'docker build -t app-image .'
                }
            }

            stage('Test') {
                steps {
                    echo "Running tests"
                }
            }

            stage('Scan') {
                steps {
                    echo "Security scanning"
                }
            }

            stage('Deploy') {
                steps {
                    echo "Deploying application"
                }
            }

        }
    }
}
