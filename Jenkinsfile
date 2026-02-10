pipeline {
    agent any

    tools {
        maven 'maven-3'
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/atul1181/ist-app.git'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }
    }

    post {
        success {
            echo '✅ Build successful'
            sh 'ls -l target'
        }
        failure {
            echo '❌ Build failed'
        }
    }
}

