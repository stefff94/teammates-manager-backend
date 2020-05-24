pipeline {
    agent {
        docker {
            image 'maven:3-alpine'
            args '-v /root/.m2:/root/.m2'
        }
    }

    stages {
        stage('Build') {
            steps {
                sh 'mvn -B -DskipTests clean package'
            }
        }

        stage('Test') {
                    steps {
                        /* sh 'mvn test' */
                        sh './mvnw verify -Pjacoco && ./mvnw verify -Pe2e-tests && ./mvnw coveralls:report'
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