pipeline {
    agent any
    triggers {
        githubPush() // Dispara el pipeline en cada push
    }
    environment {
        DOCKER_IMAGE = 'daniela019/spring-jenkins:1.0.0' // Nombre de la imagen para Docker Hub
    }
    stages {
        stage('Checkout') {
            steps {
                echo 'Clonando el repositorio...'
                git branch: 'main', url: 'https://github.com/EmiliaHerrera/spring-jenkins.git'
            }
        }
        stage('Build') {
            steps {
                echo 'Construyendo el proyecto con Maven...'
                bat './mvnw.cmd clean package -DskipTests' // Compila el proyecto sin ejecutar pruebas
            }
        }
        stage('Docker Build') {
            steps {
                echo 'Construyendo la imagen Docker...'
                bat "docker build -t ${DOCKER_IMAGE} ." // Crea la imagen con el nombre especificado
            }
        }
        stage('Docker Push') {
            steps {
                echo 'Subiendo la imagen a Docker Hub...'
                withCredentials([usernamePassword(credentialsId: 'dockerhub-credentials', usernameVariable: 'DOCKER_USERNAME', passwordVariable: 'DOCKER_PASSWORD')]) {
                    bat "docker login -u %DOCKER_USERNAME% -p %DOCKER_PASSWORD%"
                    bat "docker push ${DOCKER_IMAGE}" // Sube la imagen a Docker Hub
                echo 'Imagen subida exitosamente.'

                }
            }
        }

        stage('Docker Compose Down') {
            steps {
                echo 'Bajando cualquier instancia previa de Docker Compose...'
                bat 'docker rm -f cineAPP || true' // Elimina el contenedor peliculasAPI si existe
                bat 'docker rm -f cineAPI || true'     // Elimina el contenedor java_app si existe
                bat 'docker-compose down' // Baja cualquier instancia previa de Docker Compose

            }
        }
        stage('Docker Compose Up') {
            steps {
                echo 'Levantando los contenedores con Docker Compose...'
                bat 'docker-compose up -d' // Levanta los contenedores en segundo plano
            }
        }
    }

    post {
        always {
            echo 'Finalizando el pipeline.'
        }
        success {
            echo 'Pipeline completado exitosamente.'
        }
        failure {
            echo 'Error en el pipeline.'
        }
    }
}