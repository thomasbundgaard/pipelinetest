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
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying DJ....'
				bat 'mvn -v'
            }
        }
    }
}
