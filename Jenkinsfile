pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Maven Build and Test') {
            steps {
                sh 'mvn clean test'
            }
        }

        stage('Create JAR') {
            steps {
                sh 'mvn package -DskipTests'
            }
        }

        stage('Docker Build') {
            steps {
                sh 'docker build -t employee-management:latest .'
            }
        }

        stage('Stop Previous Container') {
            steps {
                sh 'docker rm -f employee-app || true'
            }
        }

        stage('Deploy New Container') {
            steps {
                sh 'docker run -d --name employee-app -p 8060:8060 employee-management:latest'
            }
        }
    }

    post {
        success {
            echo 'Employee Management application deployed successfully.'
        }
        failure {
            echo 'Pipeline failed. Docker deployment was not completed if an earlier stage failed.'
        }
    }
}
