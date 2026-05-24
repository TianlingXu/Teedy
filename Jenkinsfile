pipeline {
    agent any

    environment {
        DOCKER_HUB_CREDENTIALS = 'dockerhub_credentials'
        DOCKER_IMAGE = 'tianlingxu/teedy-app'
        DOCKER_TAG = "${env.BUILD_NUMBER}"
    }

    stages {
        stage('Build') {
            steps {
                checkout scm
                sh 'mvn -B -DskipTests clean package'
            }
        }

        stage('Building image') {
            steps {
                script {
                    docker.build("${env.DOCKER_IMAGE}:${env.DOCKER_TAG}")
                }
            }
        }

        stage('Upload image') {
            steps {
                script {
                    docker.withRegistry('https://registry.hub.docker.com', DOCKER_HUB_CREDENTIALS) {
                        docker.image("${env.DOCKER_IMAGE}:${env.DOCKER_TAG}").push()
                        docker.image("${env.DOCKER_IMAGE}:${env.DOCKER_TAG}").push('latest')
                    }
                }
            }
        }

        stage('Run containers') {
            steps {
                script {
                    def containers = [
                        [name: 'teedy-container-8082', port: '8082:8080'],
                        [name: 'teedy-container-8083', port: '8083:8080'],
                        [name: 'teedy-container-8084', port: '8084:8080']
                    ]
                    containers.each { c ->
                        sh "docker stop ${c.name} || true"
                        sh "docker rm ${c.name} || true"
                        docker.image("${env.DOCKER_IMAGE}:${env.DOCKER_TAG}").run("-name ${c.name} -d -p ${c.port}")
                    }
                    sh 'docker ps --filter "name=teedy-container"'
                }
            }
        }
    }
}
