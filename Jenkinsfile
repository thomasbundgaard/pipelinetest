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
                sh 'docker images'
                sh 'git clone git@github.com:thomasbundgaard/pipelinetest.git'
                sh 'ls'
                sh 'ls pipelinetest'
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
                sh 'rm -rf pipelinetest'
                junit 'target/surefire-reports/**/*.xml'
            }
        }
}
