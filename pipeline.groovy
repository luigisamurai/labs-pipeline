#!/usr/bin/env groovy

def execute() {
 def stageDefinition = load("${env.WORKSPACE}/stages/test.groovy")
  stage('test') {
    stageDefinition.executeStage(this)
  }
}

return this
