pipeline {
    agent {
        docker {
            image 'maven:3-alpine'
            args '-v /root/.m2:/root/.m2'
        }
    }

    environment{
        HEROKU_API_KEY = 6d895acb-9090-46bb-a967-14bb52e57984
    }

    stages {
        stage('Build') {
            steps {
                sh 'mvn -B -DskipTests clean package'
            }
        }

        stage('Test') {
                    steps {
                        sh 'mvn test'
                    }
                    post {
                        always {
                            junit 'target/surefire-reports/*.xml'
                        }
                    }
                }
        stage('Deliver') {
                    steps {
                        sh 'mvn -e clean heroku:deploy'
                    }
                }
    }
}