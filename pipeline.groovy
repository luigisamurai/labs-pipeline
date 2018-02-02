#!/usr/bin/env groovy

def execute(pipelineProperties) {

  def pipelineParameter =  [
    string(
        name: 'MY_VARIABLE',
        description: 'Pipeline Environment Config key',
        defaultValue: ''
    )
  ]

  def parameters = [
    string(
        name: 'MY_VARIABLE',
        description: 'Pipeline Environment Config key',
        defaultValue: ''
    )
  ]

  // for (index = 0; index < pipelineProperties.size(); index++) {
  //   println pipelineProperties[index].toString().startsWith("@parameters")
  // }
  def prop = []

  for (ParametersDefinitionProperty property in pipelineProperties) {
    if ( property.toString().startsWith("@parameters") ) {
      println property instanceof Collection
      println property instanceof Set
    } else {
      prop.add(property)
    }
  }
  
  // pipelineProperties[0]
  properties(prop)

  stage('test') {
     echo("Hello, it is my firts multi branch pipeline custom. ${env.MY_CUSTOM_PROP}")
     echo("Hello, it is my firts multi branch pipeline. ${env.PIPELINE_ENV}")
  }
}

return this
