pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'Building DJ..'
            }
        }
        stage('Test') {
            steps {
                echo 'Testing DJ..'
                bat 'mvn test'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying DJ....'
				bat 'mvn verify'
            }
        }
    }
}
