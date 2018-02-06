#!/usr/bin/env groovy
import hudson.model.ParametersDefinitionProperty
import hudson.model.JobProperty
import groovy.transform.Field

@Field final String PARAMETERS_TYPE = '@parameters'
@Field final String BUILD_DISCARDER_TYPE = '@buildDiscarder'
@Field final String PARAMETERS_KEY = '<anonymous>'

def execute(supportedEnvs, pipelineProperties = null) {
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

  // esta trabajo aun mejor
  def prop = []
  def defaultParameters =  [
    choice(
      name: 'PIPELINE_ENV',
      description: 'Target environment',
      choices: supportedEnvs.split(',').join('\n'),
      value: 'prod'
    ),
    string(
        name: 'BROWSERS',
        description: 'Comma separated list of browsers to be run. The possibles values are: chrome,firefox,ie,edge,safari',
        defaultValue: ''
    ),
    string(
        name: 'HEADLESS',
        description: 'Specify the mode Headless (virtual mode without a UI browser). The value true enable the mode headless and the void value disable it',
        defaultValue: ''
    )
  ]
  def buildDiscarderOrDefault = buildDiscarder(
    logRotator(
        artifactDaysToKeepStr: '', 
        artifactNumToKeepStr: '', 
        daysToKeepStr: 1, 
        numToKeepStr: 2))

  def parametersOrDefault = defaultParameters

  for (ParametersDefinitionProperty property in pipelineProperties) {
      if (property.toString().startsWith(PARAMETERS_TYPE)) {
        def jenkinsfileParameters = property.getArguments().get(PARAMETERS_KEY)
        parametersOrDefault = mergeParameters(jenkinsfileParameters, defaultParameters)
      } else if (property.toString().startsWith(BUILD_DISCARDER_TYPE)) {
        buildDiscarderOrDefault = property
      } else {
        prop.add(property)
    }
  }

  prop.add(
    parameters(
      parametersOrDefault
    )
  )

  prop.add(buildDiscarderOrDefault)

  properties(prop)

  stage('test') {
     echo("Hello, it is my firts multi branch pipeline custom. ${env.PIPELINE_ENV_DEFAULT}")
     echo("Hello, it is my firts multi branch pipeline. ${env.PIPELINE_ENV}")
  }
}

private mergeParameters(jenkinsfileParameters, defaultParameters) {
    def allParameters = defaultParameters

    for(parameter in jenkinsfileParameters) {
        parameterName = parameter.getArguments().name

        for(defaultParameter in defaultParameters) {
            if (defaultParameter.getArguments().name == parameterName) {
                allParameters.remove(defaultParameter)
                defaultParameter.remove(defaultParameter)
            }
        }

        allParameters.add(parameter)
    }

    return allParameters
}

return this
