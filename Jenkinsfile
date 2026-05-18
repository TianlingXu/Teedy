pipeline {
    agent any

    stages {
        stage('Clean') {
            steps {
                sh 'mvn clean'
            }
        }

        stage('Compile') {
            steps {
                sh 'mvn compile -Dpmd.skip=true'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test -Dpmd.skip=true -Dmaven.test.failure.ignore=true'
            }
        }

        stage('Site') {
            steps {
                sh 'mvn site -Dpmd.skip=true'
            }
        }

        stage('Package') {
            steps {
                sh 'mvn package -DskipTests -Dpmd.skip=true'
            }
        }
    }

    post {
        always {
            junit '**/target/surefire-reports/*.xml'

            archiveArtifacts artifacts: '**/target/site/**/*.*', fingerprint: true
            archiveArtifacts artifacts: '**/target/*.jar', fingerprint: true
            archiveArtifacts artifacts: '**/target/*.war', fingerprint: true
            archiveArtifacts artifacts: '**/target/**/*.jar', fingerprint: true
            archiveArtifacts artifacts: '**/target/**/*.war', fingerprint: true
        }
    }
}
