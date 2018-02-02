#!/usr/bin/env groovy
import hudson.model.StringParameterValue
// import hudson.model.StringParameterDefinition
// import hudson.model.ParametersDefinitionProperty
import hudson.model.ParametersAction
import com.cloudbees.groovy.cps.NonCPS

@NonCPS
def execute() {
  // def newParam = new StringParameterDefinition('foo', 'var', 'mi variable')
  // def newArrList = []
  // newArrList.add(newParam)
  // def newParamDef = new ParametersDefinitionProperty(newArrList)

  // echo("=======> el nombre es: ${currentBuild.getProjectName()}")
  // currentBuild.rawBuild.addAction(newParamDef)

  // def pa = new ParametersAction([
  //   new StringParameterValue("FOO", "BAR")
  // ])
  // currentBuild.rawBuild.addAction(pa)

  parameters(
    choice(
        name: 'Nodes',
        choices:"Linux\nMac",
        description: "Choose Node!")
    choice(
        name: 'Versions',
        choices:"3.4\n4.4",
        description: "Build for which version?" )
    string(
        name: 'Path',
        defaultValue:"/home/pencillr/builds/",
        description: "Where to put the build!")
  )


  stage('test') {
    echo("Hello, it is my firts multi branch pipeline. ${env.FOO}")
  }
}

return this
