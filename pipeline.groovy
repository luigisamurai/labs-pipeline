#!/usr/bin/env groovy
import hudson.model.ParametersDefinitionProperty
import hudson.model.JobProperty

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
      name: 'OTRO',
      description: 'OTRO'
    ),
    string(
      name: 'OTRO_MAS',
      description: 'OTRO_MAS'
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
      if (property.toString().startsWith("@parameters")) {
        def jenkinsfileParameters = property.getArguments().get('<anonymous>')

        for(index = 0; index < jenkinsfileParameters.size(); index ++) {
          parameter = jenkinsfileParameters.get(index)
          parameterName = parameter.getArguments().name

          // for(defualtIndex = 0; defualtIndex < parametersOrDefault.size(); defualtIndex ++) {
          //   defualtParameter = parametersOrDefault.get(defualtIndex)
          //   println defualtParameter.getArguments().name
          //   if (defualtParameter.getArguments().name == parameterName) {
          //     parametersOrDefault.remove(defualtIndex)
          //   }
          // }

          parametersOrDefault.add(parameter)
        }
      } 
      if (property.toString().startsWith("@buildDiscarder")) {
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

return this
