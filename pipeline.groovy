#!/usr/bin/env groovy

def execute(pipelineProperties) {

  println pipelineProperties['parameters']
  properties(pipelineProperties)

  stage('test') {
     echo("Hello, it is my firts multi branch pipeline custom. ${env.MY_CUSTOM_PROP}")
     echo("Hello, it is my firts multi branch pipeline. ${env.PIPELINE_ENV}")
  }
}

return this
