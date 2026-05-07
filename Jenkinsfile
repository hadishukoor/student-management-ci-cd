pipeline {
    agent any

    stages {

        stage('Clone Repository') {
            steps {
                git 'https://github.com/hadishukoor/student-management-ci-cd.git'
            }
        }

        stage('Build Application') {
            steps {
                bat 'mvn clean package'
            }
        }

        stage('Build Docker Image') {
            steps {
                bat 'docker build -t student-management-app .'
            }
        }

        stage('Run Docker Container') {
            steps {
                bat 'docker stop student-management-container || exit 0'
                bat 'docker rm student-management-container || exit 0'
                bat 'docker run -d -p 8081:8081 --name student-management-container student-management-app'
            }
        }

    }
}