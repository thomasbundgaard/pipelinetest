pipeline {
    agent {
        label "master"
    }
       stages {
        stage('Build') {
            steps {
                echo 'Building DJ now from github..'
            }
        }
        stage('Test') {
            steps {
                echo 'Testing DJ..'
                bat 'mvn install'
            }
        }
        stage('run on ubuntu') {
            agent {
                label "ubuntu"
            }
            options { skipDefaultCheckout() }
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
