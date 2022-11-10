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
                        sh(script: "mvn clean test '-Dcucumber.filter.tags=@Regression' -Dselenium_location='$SELENIUM_LOCATION' -Dselenium_username='$SELENIUM_USERNAME' -Dselenium_password='$SELENIUM_PASSWORD' -Dbase_url='$JIRA_BASE_URL' -Dusername='$JIRA_USERNAME' -Dpassword='$JIRA_PASSWORD' -Dshort_wait=$SHORT_WAIT -Dlong_wait=$LONG_WAIT -Dbrowser=chrome")
                    }
                }
                stage("Regression Firefox"){
                    steps{
                        sh(script: "mvn clean test '-Dcucumber.filter.tags=@Regression' -Dselenium_location='$SELENIUM_LOCATION' -Dselenium_username='$SELENIUM_USERNAME' -Dselenium_password='$SELENIUM_PASSWORD' -Dbase_url='$BASE_URL' -Dusername='$USERNAME' -Dpassword='$PASSWORD' -Dshort_wait=$SHORT_WAIT -Dlong_wait=$LONG_WAIT -Dbrowser=firefox")
                    }
                }
            }
        }
        stage("New feature testing"){
            parallel{
                stage("With Chrome"){
                    steps{
                        echo "Not yet implemented"
                    }
                }
                stage("With Firefox"){
                    steps{
                        echo "Not yet implemented"
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
