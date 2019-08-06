pipeline {
    environment {
        registry = "thomasbundgaard/testrepo"
        registryCredential = 'dockerhub'
    }
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
                script {
                    myImg = docker.build (registry + ":$BUILD_NUMBER", "pipelinetest/builder")
                    //docker.withRegistry([credentialsId: registryCredential, url:""]) {
                    withDockerRegistry([credentialsId: registryCredential, url:""]) {
                        myImg.push "$BUILD_NUMBER"
                    }
                }
                sh 'docker images'
                sh 'rm -rf pipelinetest'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying DJ....'
                bat "kubectl create deployment my$BUILD_NUMBER-node --image=thomasbundgaard/testrepo:$BUILD_NUMBER"
                bat "kubectl expose deployment my$BUILD_NUMBER-node --type=LoadBalancer --port=8080"
                bat "minikube-windows-amd64.exe service my$BUILD_NUMBER-node"
            }
        }
    }
    post {
            always {
                junit 'target/surefire-reports/**/*.xml'
            }
        }
}
