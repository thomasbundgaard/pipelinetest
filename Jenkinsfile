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
                echo 'on mynewbranch'
            }
        }
    }

}
