#!/usr/bin/env groovy

def execute(pipelineProperties) {

  print "====> Symbol: " + pipelineProperties[0].getSymbol()
  print "====> getKlass: " + pipelineProperties[0].getKlass()
  print "====> getModel: " + pipelineProperties[0].getModel()
  print "====> getArguments: " + pipelineProperties[0].getArguments().values()
  print "====> toMap: " + pipelineProperties[0].toMap().get("@parameters")

  def prop = []

  for (ParametersDefinitionProperty property in pipelineProperties) {
      if (property.toString().startsWith("@parameters")) {

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
