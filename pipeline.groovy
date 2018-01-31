#!/usr/bin/env groovy

def execute() {
 def stageDefinition = load("${env.WORKSPACE}/stages/test.groovy")
  echo("${env.WORKSPACE}/stages/test.groovy")
  stage('test') {
    stageDefinition.executeStage()
  }
}

return this
