pipeline {
    agent any
    tools {
            maven 'Maven 3.6.0'
         }

    stages {
        stage('Build') {
            steps {
                echo 'Building DJ..'
            }
        }
        stage('Test') {
            steps {
                echo 'Testing DJ..'
                bat 'mvn install'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying DJ....'
            }
        }
    }
    post {
            always {
                junit 'target/surefire-reports/**/*.xml'
            }
        }
}
