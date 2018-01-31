#!/usr/bin/env groovy
// import hudson.model.ParameterValue;
import hudson.model.ParametersAction;
import hudson.model.StringParameterValue
// import hudson.model.ParameterDefinition
// import hudson.model.StringParameterDefinition
// import hudson.model.ParametersDefinitionProperty


// @Field final String TEST_ENV_PARAMETER = 'PIPELINE_ENV'

def execute() {
    // def jenkinsfileParameters = currentBuild.rawBuild.getAction(ParametersAction.class)
    // def jenkinsbuilds = currentBuild.rawBuild.getAction(BuildDiscarder.class)

    // def jenkinsfileParameters = currentBuild.rawBuild.getAction(ParametersAction.class)
    // def allParameters = []

    // def pipelineParameter =  string(
    //     name: TEST_ENV_PARAMETER,
    //     description: 'Pipeline Environment Config key',
    //     defaultValue: env.DEFAULT_PIPELINE_ENV
    // )

    // allParameters.add(pipelineParameter)

    // for(ParameterValue parameter in jenkinsfileParameters) {
    //     println parameter.name
    //     println parameter.getDefinition().getType()
    //     def item

    //     if (parameter.choices) {
    //         item = choice(
    //             name: parameter.name,
    //             description: description: parameter.description,
    //             choices: parameter.choices,
    //             defaultValue: parameter.defaultValue
    //         )
    //     } else if () {

    //     } else {
    //         item = string(
    //             name: parameter.name,
    //             description: parameter.description,
    //             defaultValue: parameter.defaultValue
    //         )
    //     }
    //     allParameters.add(item)
    // }

    // properties([
    //     buildDiscarder(
    //         logRotator(artifactDaysToKeepStr: '', 
    //                 artifactNumToKeepStr: '', 
    //                 daysToKeepStr: env.DISCARD_DAYS, 
    //                 numToKeepStr: env.DISCARD_NUMBER_BUILDS)),
    //     parameters(allParameters)
    // ])

    // properties([
    //     buildDiscarder(jenkinsbuilds),
    //     parameters(jenkinsfileParameters)
    // ])

  // def changeLogSets = currentBuild.changeSets
  // for (int i = 0; i < changeLogSets.size(); i++) {
  //     def entries = changeLogSets[i].items
  //     for (int j = 0; j < entries.length; j++) {
  //         def entry = entries[j]
  //         echo "${entry.commitId} by ${entry.author} on ${new Date(entry.timestamp)}: ${entry.msg}"
  //         def files = new ArrayList(entry.affectedFiles)
  //         for (int k = 0; k < files.size(); k++) {
  //             def file = files[k]
  //             echo "  ${file.editType.name} ${file.path}"
  //         }
  //     }
  // }

  // key   = 'GEM_SOURCE'
  // value = 'http://rubygems.delivery.puppetlabs.net'
  // desc  = 'The Rubygems Mirror URL'

  // for(job in Hudson.instance.items) {

  //     println("[ " + job.name + " ] setting " + key + "=" + value)

  //     newParam = new StringParameterDefinition(key, value, desc)
  //     paramDef = job.getProperty(ParametersDefinitionProperty.class)

  //     if (paramDef == null) {
  //         newArrList = new ArrayList(1)
  //         newArrList.add(newParam)
  //         newParamDef = new ParametersDefinitionProperty(newArrList)
  //         job.addProperty(newParamDef)
  //     }
  //     else {
  //         // Parameters exist! We should check if this one exists already!
  //         found = paramDef.parameterDefinitions.find{ it.name == key }
  //         if (found == null) {
  //             paramDef.parameterDefinitions.add(newParam)
  //         }
  //     }
  //     //job.save()
  //     println()
  // }

  newParam = new StringParameterDefinition('foo', 'var', 'mi variable')
  // paramDef = currentBuild.getProperty(ParametersDefinitionProperty.class)

  def newArrList = new ArrayList<ParametersDefinitionProperty>[]
  newArrList.add(newParam)
  newParamDef = new ParametersDefinitionProperty(newArrList)
  // currentBuild.addAction(newParamDef)

  // def build = Thread.currentThread().executable
  // def pa = new ParametersAction([
  //   new StringParameterValue("FOO", "BAR")
  // ])
  // currentBuild.addAction(pa)

  // currentBuild.addProperty(
  //   new ParametersDefinitionProperty(
  //     new StringParameterDefinition("FOO", "bar", "")
  //   )
  // );

  stage('test') {
    echo('Hello, it is my firts multi branch pipeline.')
  }
}

return this
