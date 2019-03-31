pipeline {
    agent {
        docker {
            image 'maven:3.6.0-jdk-11-slim'
            args '-v $HOME/.m2:/root/.m2'
        }
    }
    stages {
        stage('compile') {
            steps {
                sh 'mvn compile'
            }
        }
    }
}
