pipeline {
    agent none
       stages {
        stage('Build') {
            steps {
                echo 'Building DJ..'
            }
        }
        stage('Test') {
            agent {
                node none
            }
            steps {
                echo 'Testing DJ..'
                bat 'mvn install'
            }
        }
        stage('run on ubuntu') {
            agent {
                label "ubuntuagent"
            }
            steps {
                echo 'run on ubuntu'
                sh 'ls'
                sh 'pwd'
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
