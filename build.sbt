/* DO NOT USE BLOOP ! */

















import sbtcrossproject.CrossProject

import Build.mainly._

lazy val lscAlgLibProject
=
  (crossProject(suggestedTargetPlatforms.+:(JVMPlatform ) : _* ).withSuggestedSettings() in (packagesParentDir / "lscalg" ) )
  .asLeafProjectWithNecessarySettings()

lazy val lscAnsioProject
= {
  ;

  (crossProject(suggestedTargetPlatforms.+:(JVMPlatform ) : _* ).withSuggestedSettings() in (packagesParentDir / "lscoreansio" ) )
  .asLeafProjectWithNecessarySettings()

  .dependsOn(lscAlgLibProject )
  /* to avoid further "not found symbol" complications JLine should be promoted to being cross-platform dependency */
  /* presently it will fail to link on SJS, but there's a future possibility of one */
  .settings(
    libraryDependencies +=
        "org.jline" % "jline" % "3.25.0"
    ,
  )

  /* unlike JLine, JNA should, and could safely be restricted to `JVMPlatform` */
  .platformsSettings(JVMPlatform) (
    // <dependency org="net.java.dev.jna" name="jna" rev="5.14.0"/>
    libraryDependencies +=
      ("net.java.dev.jna" % "jna" % "5.14.0")
    ,
  )
}

lazy val kscProject
= {
  ;

  (crossProject(suggestedTargetPlatforms : _* ).withSuggestedSettings() in (packagesParentDir / "ksc" ) )
  .asLeafProjectWithNecessarySettings()

  .dependsOn(lscAlgLibProject )
  .dependsOn(lscAnsioProject )
}

lazy val main1
= {
  ;

  (crossProject(suggestedTargetPlatforms : _* ).withSuggestedSettings() in (packagesParentDir / "main1" ) )
  .asLeafProjectWithNecessarySettings()

  /* as a main-app */
  .withDbp(mainClassNames = Some("runSMain") )
  .dependsOn(lscAlgLibProject )
  .dependsOn(lscAnsioProject )
  .dependsOn(kscProject )
  .withJavaUtilLocaleCQuiroz()
}













