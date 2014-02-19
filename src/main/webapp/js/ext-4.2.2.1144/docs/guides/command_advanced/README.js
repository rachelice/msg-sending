Ext.data.JsonP.command_advanced({"title":"Advanced Sencha Cmd","guide":"<h1>Advanced Sencha Cmd</h1>\n<div class='toc'>\n<p><strong>Contents</strong></p>\n<ol>\n<li><a href='#!/guide/command_advanced-section-1'>Installation Considerations</a></li>\n<li><a href='#!/guide/command_advanced-section-2'>Configuration</a></li>\n<li><a href='#!/guide/command_advanced-section-3'>Command Line Details</a></li>\n<li><a href='#!/guide/command_advanced-section-4'>Plugins</a></li>\n<li><a href='#!/guide/command_advanced-section-5'>Use in Ant</a></li>\n</ol>\n</div>\n\n<p>This guide covers capabilities of <a href=\"http://www.sencha.com/products/sencha-cmd/download\">Sencha Cmd</a>\navailable to advanced users. Before using this functionality, read\n<a href=\"#!/guide/command\">Introduction to Sencha Cmd</a> and use the commands.</p>\n\n<h2 id='command_advanced-section-1'>Installation Considerations</h2>\n\n<h3>Location</h3>\n\n<p>The Installer lets you select a destination path, but changing this can have side effects\n(see the section \"Multiple Installed Versions\"). Ideally, all versions of Sencha Cmd are\ninstalled in a single base folder with sub-folders named by the version number. On Windows,\nthe default install folder for a single-user installation looks like this:</p>\n\n<pre><code>C:\\Users\\myself\\bin\\Sencha\\Cmd\\n.n.n.n\\\n</code></pre>\n\n<p>If you change this path, preserve the version number folder as well as installing any other\nversions of Sencha Cmd in that same parent folder.</p>\n\n<h3>Multiple Installed Versions</h3>\n\n<p>At the command prompt, all calls to <code>sencha</code> go to the most recently installed version\nof Sencha Cmd. Sometimes this version may not be compatible with the current\napplication.</p>\n\n<p>To support such scenarios, Sencha Cmd looks at the required version as specified by the\nframework used by the application. It then delegates the command to the the proper version\nof Sencha Cmd.</p>\n\n<p><strong>Important</strong> For this to work properly, both versions must be installed in a folder\nnamed by their version number and located in a common parent folder.</p>\n\n<p>Alternatively, each installed version also provides a version-specific name for Sencha Cmd.\nThis can be run as follows:</p>\n\n<pre><code>sencha-n.n.n ....\n</code></pre>\n\n<p>The installer also sets an environment variable of the form <code>SENCHA_CMD_n_n_n</code>,\nwhich can be used to adjust the PATH of the current console/shell, as follows.</p>\n\n<p>On Windows, this looks like this (n is the current version):</p>\n\n<pre><code>set PATH=%SENCHA_CMD_n_n_n%;%PATH%\nsencha ....\n</code></pre>\n\n<p>On OSX/Linux, this looks like this:</p>\n\n<pre><code>set PATH=$SENCHA_CMD_n_n_n:$PATH\nsencha ....\n</code></pre>\n\n<h2 id='command_advanced-section-2'>Configuration</h2>\n\n<p>Any parameter that can be passed to Sencha Cmd on the command line can be set as a\nconfiguration option in one of the configuration files discussed below. If you know the\ncommand line option, it is a simple matter to add that option to a configuration file.</p>\n\n<p>For example, to specify the <code>ignore</code> parameter for <code>sencha compile</code> in the configuration,\nadd this line:</p>\n\n<pre><code>sencha.compile#ignore=attic\n</code></pre>\n\n<p>This particular setting is not necessarily a recommended practice, but it just serves to\nillustrate the syntax. The parts of the command that goes before the <code>#</code> are the Sencha\nCmd commands separated by dots. Following the <code>#</code> is the option name.</p>\n\n<p>To set global options (like <code>debug</code> logging), do this:</p>\n\n<pre><code>sencha#debug=true\n</code></pre>\n\n<p>Configuration becomes more important over time as Sencha Cmd (especially the compiler)\nevolves.</p>\n\n<h3>Configuration Files</h3>\n\n<p>Similar to Apache Ant (on which many aspects of Sencha Cmd are based), configuration is\napplied in a \"first-write-wins\" model. This is essential to allow property values to be\noverridden by the command line.</p>\n\n<p>The process of loading configuration begins by searching from the current directory and\nproceeds up the file system until the Workspace is found. Along the way, Sencha Cmd looks\nfor the presence of an application or Sencha Framework SDK. At the end of the loading\nprocess, Sencha Cmd loads any of the following files it detects in this order:</p>\n\n<ul>\n<li><strong><code>${app.dir}/.sencha/app/sencha.cfg</code></strong> - Application configuration when in an application\nfolder that is the most specific loads first.</li>\n<li><strong><code>${package.dir}/.sencha/package/sencha.cfg</code></strong> - Package configuration when in a package\nfolder that is the most specific loads next.</li>\n<li><strong><code>${workspace.dir}/.sencha/workspace/sencha.cfg</code></strong> - Workspace configuration applies\nnext when you are in a workspace (or an app or package in the workspace).</li>\n<li><strong><code>${framework.dir}/cmd/sencha.cfg</code></strong> - Based on the applicable framework for the app or\npackage at the current directory, those properties load next.</li>\n<li><strong><code>${home.dir}/.sencha/cmd/sencha.cfg</code></strong> - Your personal configuration\nloads next. This typically only sets high-level properties.</li>\n<li><strong><code>${cmd.dir}/../sencha.cfg</code></strong> - Local machine Cmd configuration\nloads next. This typically only sets high-level properties. This loads from the\nparent folder of the running Sencha Cmd, which is the folder that holds\nthe various installed versions of Sencha Cmd.</li>\n<li><strong><code>${cmd.dir}/sencha.cfg</code></strong> - Lastly, the Sencha Cmd, version specific configuration\nloads.</li>\n</ul>\n\n\n<p>This yields basically the same result as the legacy Sencha Cmd v3.0 approach that used a cascade\nthat loaded the above files in reverse order but overwrote properties as it progressed.\nThe key difference between Sencha Cmd v3.0 and later is that properties passed at the\ncommand line override those in these files. This is seen in the following command:</p>\n\n<pre><code>sencha config -prop foo=42 then ...\n</code></pre>\n\n<p>This sets <code>\"foo\"</code> to 42 prior to the loading the config files, and in Sencha Cmd v3.1 and later,\nthis setting is \"win\".</p>\n\n<h3>Java System Properties</h3>\n\n<p>Java System Properties may need to be set for Sencha Cmd, such as HTTP Proxy Server settings.\nThe <code>\"sencha.cfg\"</code> file in your Cmd install folder\nhas default settings for proxies that enable detection of your system-defined proxy.\nFor further information, consult the comments found in <code>\"${cmd.dir}/sencha.cfg\"</code>.</p>\n\n<p><strong>NOTE:</strong> If you need to change any of these settings, use the\n<code>\"${cmd.dir}/../sencha.cfg\"</code> file so that these settings are preserved across Cmd\nupgrades.</p>\n\n<p>These properties effect Sencha Cmd's ability to access the Web to perform\n<code>sencha upgrade</code> or to download packages. These options are in Cmd v3.1.1 and later.</p>\n\n<h2 id='command_advanced-section-3'>Command Line Details</h2>\n\n<p>These tricks help if you make frequent use of Sencha Cmd.</p>\n\n<h3>Shortest Unique Prefix</h3>\n\n<p>All commands, categories and options in Sencha Cmd can be specified by their full name or\nby the shortest prefix that is unique.</p>\n\n<p>To illustrate, since <code>generate</code> is the only top-level category in Sencha Cmd that currently\nstarts with the letter \"g\", and likewise, <code>app</code> is the only command in that category that\nstarts with an \"a\", the following commands are equivalent:</p>\n\n<pre><code>sencha generate app MyApp ../MyApp\nsencha gen ap MyApp ../MyApp\n</code></pre>\n\n<p><strong>Important</strong> While this can be convenient at the console or terminal, it is not a good\npractice to use extremely short/terse prefixes in scripts. The use of terse commands\nin scripts makes it hard to understand or maintain the script,\nand can break if new commands make the short form ambiguous.</p>\n\n<h3>Command Chaining</h3>\n\n<p>The Sencha Cmd command line processor executes all commands given to it until they have\nall been dispatched. This means you can avoid the cost of relaunching the Sencha Cmd\nprocess to execute multiple commands. To take advantage of this, insert <code>and</code> or <code>then</code>\nbetween commands.</p>\n\n<p>The <code>and</code> and <code>then</code> commands are based on the execution model of Sencha Cmd and its\nhierarchical structure of commands and categories. The <code>and</code> command is used to execute\nanother command in the same category as the previous command. This is the most common use\ncase.</p>\n\n<p>For example, to generate a controller and two models, use this:</p>\n\n<pre><code>cd /path/to/MyApp\nsencha generate controller Central and model User id:int and model Ticket id,name,email\n</code></pre>\n\n<p>In the above, the two uses of <code>and</code> caused two <code>generate model</code> commands to be executed.\nThe <code>then</code> command is similar to <code>and</code>, except that the next command will be part of the\nroot category (that is, the <code>sencha</code> command).</p>\n\n<p>For example, the following generates a new model, then builds the application:</p>\n\n<pre><code>cd /path/to/MyApp\nsencha generate model User id:int,name then app build\n</code></pre>\n\n<h3>Response Files</h3>\n\n<p>When command chaining starts to make command lines too long to be readable, perhaps in a\ncomplex build script, you can put command line arguments in a file and tell Sencha Cmd to\nread arguments from that file.</p>\n\n<p>For example:</p>\n\n<pre><code>cd /path/to/MyApp\nsencha @file.sencha\n</code></pre>\n\n<p>In the above, the <code>\"file.sencha\"</code> file is read and each line is taken to be a command line\nargument, unless that line begins with \"#\", in which case it is skipped. All lines from\nthe specified file are inserted into the command line arguments as if they had been typed\nthere instead of <code>\"@file.sencha\"</code>. This means that <code>\"file.sencha\"</code> can contain response file\ninsertions as well (for example, <code>\"@file2.sencha\"</code>).</p>\n\n<h3>Category State</h3>\n\n<p>For performance reasons, some categories maintain state across multiply executed commands.\nThe best example of this is the new <code>compile</code> category of commands. Instead of reading all\nthe sources for each command, the <code>compile</code> category maintains a cache of all the files in\nthe class path. This context is then available to all of the commands in the category.</p>\n\n<p>The following command rebuilds the <code>ext-all-dev.js</code> and <code>ext-all.js</code> files while reading\nthe framework sources only once:</p>\n\n<pre><code>cd /path/to/MyApp\nsencha compile -c sdk/src --debug=true concat -o sdk/ext-all-dev.js \\\n    and --debug=false concat -c -o sdk/ext-all.js\n</code></pre>\n\n<p>If you don't want to use this caching, perhaps because the set of files is not the same\nfor the next set of outputs, use the <code>then</code> command, like this:</p>\n\n<pre><code>cd /path/to/MyApp\nsencha compile -c sdk/src --debug=true concat -o sdk/ext-all-dev.js \\\n     then compile -c app/foo --debug=true concat -o app/foo/foo-all.js\n</code></pre>\n\n<p>At present, only the <code>compile</code> category maintains state across commands.</p>\n\n<h2 id='command_advanced-section-4'>Plugins</h2>\n\n<p>While the same Sencha Cmd install is used by both Ext JS and Sencha Touch, there are many\ntimes when commands perform slightly different operations depending on the framework.\nFurther, some commands may only be available for one framework.</p>\n\n<p>To accommodate this, the functionality of Sencha Cmd is partitioned across two layers: the\ncommand line (properly called \"Sencha Cmd\") and the lower-level interface for use in\n<a href=\"http://ant.apache.org/\">Ant</a>. Commands that have these special concerns are routed from\nthe command line into a plugin.</p>\n\n<p><p><img src=\"guides/command_advanced/sencha-command-diagram.png\" alt=\"\"></p></p>\n\n<p>A Sencha Cmd plugin is just an Ant script contained in a file called <code>\"plugin.xml\"</code> though\nfor any given command, executed in an application or workspace, there are potentially\nseveral active plugins.</p>\n\n<p>The process begins by looking for the most specific plugin available as follows:</p>\n\n<ul>\n<li><code>${app.dir}/.sencha/app/plugin.xml</code></li>\n<li><code>${workspace.dir}/.sencha/workspace/plugin.xml</code></li>\n<li><code>${cmd.dir}/plugins/${framework.name}/${framework.plugin.version}/plugin.xml</code></li>\n<li><code>${cmd.dir}/plugin.xml (also known as the \"default plugin\")</code></li>\n</ul>\n\n\n<p>The first of these to be found is based on the current directory. Sencha Cmd\nthen loads only that plugin and invokes specific targets based on the command it was given.\nThese plugins, however, contain the Ant invocation required to load the plugin at the next\nlevel up. For example, if the application plugin is found, it contains an <code>import</code> of the\nworkspace plugin. That plugin contains an <code>import</code> of the framework plugin and, lastly,\nthat contains an <code>import</code> of the default plugin.</p>\n\n<h3>Extension Points</h3>\n\n<p>Technically, the lowest two levels (the framework and default plugins) are the only plugins\nthat contain actual code. The application and workspace plugins are empty by default but\nare present to allow for user extension of these built-in commands. The purpose for this\nis to allow you to add logic to enforce project or application standards for code\ngeneration requests made to Sencha Cmd.</p>\n\n<p>If you want to check to see if new model definitions follow project guidelines, for example,\nthe first field is always <code>id:string</code>, add this to the application or\nworkspace <code>\"plugins.xml\"</code>:</p>\n\n<pre><code>&lt;target name=\"-before-generate-model\"&gt;\n    &lt;if&gt;\n        &lt;not&gt;&lt;matches string=\"${args.fields}\" pattern=\"^id\\:string,.*\"/&gt;&lt;/not&gt;\n        &lt;then&gt;\n            &lt;fail&gt;Models must have \"id:string\" as first field.&lt;/fail&gt;\n        &lt;/then&gt;\n    &lt;/if&gt;\n&lt;/target&gt;\n</code></pre>\n\n<p>Similarly you can also provide a hook to update other systems when a new model has been\nadded.</p>\n\n<pre><code>&lt;target name=\"-after-generate-model\"&gt;\n    ... post new/updated Model ${args.name} and ${args.fields} ...\n&lt;/target&gt;\n</code></pre>\n\n<p>The actual target names differ by which plugin you extend. For\nspecifics, consult the comments in the respective <code>\"plugin.xml\"</code> file.</p>\n\n<p><strong>Note.</strong> The default <code>\"plugin.xml\"</code> file imports <a href=\"http://ant-contrib.sourceforge.net/\">Ant Contrib</a>\nwhich provides many <a href=\"http://ant-contrib.sourceforge.net/tasks/tasks/index.html\">useful tasks</a>.</p>\n\n<h2 id='command_advanced-section-5'>Use in Ant</h2>\n\n<p>While the primary use of Sencha Cmd is at the command line (hence its name), Sencha Cmd is\nalso usable directly from Ant. For details about the many commands provided at this level,\nsee the <a href=\"#!/guide/command_ant\">Ant Integration</a> guide.</p>\n"});