pipeline{
  agent any
  
  stages {
        stage("Build"){
            steps{
                sh(script: "mvn compile")
            }
        }
        stage("Regression testing"){
            parallel{
                stage("Regression Chrome"){
                    steps{
                        sh(script: "mvn clean test")
                    }
                }
                stage("Regression Chrome"){
                    steps{
                        sh(script: "mvn clean test")
                    }
                }
            }
        }
        stage("New featire testing"){
            parallel{
                stage("With Chrome"){
                    steps{
                        sh(script: "mvn clean test -Dbrowsertype=chrome")
                    }
                }
                stage("With Firefox"){
                    steps{
                        sh(script: "mvn clean test -Dbrowsertype=firefox")
                    }
                }
            }
            post {
                always {
                    junit testResults: '**/target/surefire-reports/TEST-*.xml', skipPublishingChecks: true
                    cleanWs()
                }
            }
        }
    }
}
