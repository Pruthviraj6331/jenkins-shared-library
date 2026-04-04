🚀 Jenkins Shared Library with EC2 Integration

📌 Project Overview

This project demonstrates how to create and use a Jenkins Shared Library with Jenkins running on an AWS EC2 instance.

It helps to:

Reuse pipeline code
Maintain consistency across projects
Simplify CI/CD pipeline development

🎯 Objective

Install Jenkins on AWS EC2
Create a Shared Library
Connect the library to Jenkins
Execute pipeline using shared functions
Verify successful pipeline execution



🏗️ Architecture

Developer → GitHub Repository → Jenkins (EC2) → Pipeline Execution


                                                              

⚙️ Technologies Used

Jenkins

AWS EC2

GitHub

Groovy (Shared Library)

Linux


🚀 Implementation Steps
1. EC2 Setup
Launch EC2 instance
Install Java (required for Jenkins)
Install Jenkins
Start Jenkins service

2. Jenkins Configuration
Access Jenkins using EC2 Public IP
Unlock Jenkins using admin password
Install required plugins

3. Shared Library Setup
Create GitHub repository
Add folders:
vars/
src/
Add reusable pipeline functions

4. Connect Library to Jenkins
Go to Manage Jenkins → Configure System
Add Global Pipeline Library
Provide GitHub repository URL

5. Pipeline Execution
Create a Jenkins pipeline
Import shared library using:
@Library('jenkins-shared-library') _
Run pipeline

6. Validation
Library loaded successfully ✅
Pipeline executed without errors ✅
Output verified in Jenkins console ✅


🔐 Sample Pipeline
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

📊 Benefits
Reusable pipeline code
Faster development
Centralized CI/CD logic
Easy maintenance
Scalable for multiple projects

📌 Conclusion

This project demonstrates how to successfully integrate a Jenkins Shared Library with Jenkins running on AWS EC2, enabling efficient and reusable CI/CD pipelines.

🔗 Author

Pruthviraj Desai

