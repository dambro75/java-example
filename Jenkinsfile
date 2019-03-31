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

    stages {
        stage('sonarqube') {
            steps {
                sh 'mvn sonar:sonar -Dsonar.projectKey=java-example -Dsonar.host.url=https://sonar.eks.criptalia.it -Dsonar.login=6e51a5989b5c0c848df36eb640f13a81dc2e0653'
            }
        }
    }
}
