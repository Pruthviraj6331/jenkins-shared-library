🚀 Jenkins Shared Library (EC2 Setup)
📌 What is this project?

This project shows how to use a Jenkins Shared Library with Jenkins installed on an AWS EC2 instance.

In this project, I have:

Installed Jenkins on AWS EC2
Created a Jenkins Shared Library
Connected the library to Jenkins
Ran a pipeline using the shared library
Verified that everything works correctly ✅
☁️ Jenkins Setup on EC2

Jenkins is installed on an EC2 instance.

🔹 Details:
Server: AWS EC2
OS: Ubuntu / Amazon Linux
Jenkins Port: 8080

Access URL:

http://<EC2-Public-IP>:8080
⚙️ Steps to Install Jenkins

Run these commands on EC2:

sudo apt update
sudo apt install openjdk-11-jdk -y
sudo apt install jenkins -y
sudo systemctl start jenkins
sudo systemctl enable jenkins

To get Jenkins password:

sudo cat /var/lib/jenkins/secrets/initialAdminPassword
📂 Project Structure
jenkins-shared-library/
│── vars/        # Contains pipeline functions
│── src/         # Contains reusable code
│── resources/   # Optional files
│── README.md
🔧 How to Connect Shared Library in Jenkins
Go to Manage Jenkins
Click Configure System
Find Global Pipeline Libraries
Add these details:
Name: jenkins-shared-library
Branch: main

Git URL:

https://github.com/Pruthviraj6331/jenkins-shared-library.git
🧪 Pipeline Test

Example Jenkinsfile:

@Library('jenkins-shared-library') _

pipeline {
    agent any

    stages {
        stage('Test') {
            steps {
                script {
                    echo "Shared Library working successfully!"
                }
            }
        }
    }
}
✅ Result
Jenkins is running on EC2
Shared library connected successfully
Pipeline executed without errors
Output verified in Jenkins console
🛠️ Features
Easy to reuse pipeline code
Saves time (no need to write same code again)
Clean and organized CI/CD process
Works on real AWS environment
👨‍💻 Author

Pruthviraj Desai
GitHub: https://github.com/Pruthviraj6331
