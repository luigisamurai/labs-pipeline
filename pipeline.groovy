#!/usr/bin/env groovy
import hudson.model.ParametersDefinitionProperty
import hudson.model.JobProperty

def execute(pipelineProperties) {
  // Codigo que ha funcionando
  // def defaultParameters =  [
  //     string(
  //     name: 'CUSTOM',
  //     description: 'Pipeline Environment Config key',
  //     defaultValue: 'CUSTOM---..'
  //   ),
  //   string(
  //     name: 'OTRO',
  //     description: 'OTRO',
  //     defaultValue: 'OTRO---..'
  //   )
  // ]

  // def allParameters = pipelineProperties[0].getArguments().get('<anonymous>')
  // allParameters.addAll(defaultParameters)

  // def prop = []
  // prop.add(
  //   parameters(
  //     allParameters
  //   )
  // )
  // prop.add(pipelineProperties[1])
  // prop.add(pipelineProperties[2])

  // properties(prop)

  // Codigo que ha funcionando

  // properties([
  //   parameters(
  //     allParameters
  //   ),
  //   pipelineProperties[1],
  //   pipelineProperties[2]
  // ])

  def prop = []
  def defaultParameters =  [
      string(
      name: 'CUSTOM',
      description: 'Pipeline Environment Config key',
      defaultValue: 'CUSTOM---..'
    ),
    string(
      name: 'OTRO',
      description: 'OTRO',
      defaultValue: 'OTRO---..'
    )
  ]

  for (ParametersDefinitionProperty property in pipelineProperties) {
      if (property.toString().startsWith("@parameters")) {
        allParameters = pipelineProperties[0].getArguments().get('<anonymous>')
        allParameters.addAll(defaultParameters)

        prop.add(
          parameters(
            allParameters
          )
        )
      } else {
        prop.add(property)
    }
  }

  properties(prop)

  stage('test') {
     echo("Hello, it is my firts multi branch pipeline custom. ${env.PIPELINE_ENV_DEFAULT}")
     echo("Hello, it is my firts multi branch pipeline. ${env.PIPELINE_ENV}")
  }
}

return this
