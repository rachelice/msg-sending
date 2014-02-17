/*
 * [{
    // 表头第一列，该列也是树形列(aList：把这一列的数据作为aList)，可以看图一
  &nbsp; task:'Project: Shopping',
    // 表头第二列，从这列开始就是与第一列的每一个节点所对应的数据字段了（把从第二以及以后列的数据作为bList）
    duration:13.25,
    user:'Tommy Maintz',// 表头第三列
    iconCls:'task-folder',// 节点图标样式，与数据无关
    expanded: true,//是否可以展开，与数据无关
    // 接下来就是上面那个节点task:'Project: Shopping'的子节点以及子节点对应的数据
   children:[{
      // 表头第一列，该列也是树形列(aList：把这一列的数据作为aList)，可以看图一
        task:'Housewares',
        // 表头第二列，从这列开始就是与第一列的每一个节点所对应的数据字段了（把从第二以及以后列的数据作为bList）
        duration:1.25,
        user:'Tommy Maintz',// 表头第三列
        iconCls:'task-folder',// 节点图标样式，与数据无关
        
        // 接下来就是上面那个节点task:'Project: Shopping'的子节点以及子节点对应的数据
   children:[{
            task:'Kitchen supplies',
            duration:0.25,
            user:'Tommy Maintz',
            leaf:true,
            iconCls:'task'
        }
   // 下面的代码我就略去了，上面的编码已经说明了Treegrid的数据格式
   // 首先task这个属性是固定的
   .......
    ]}
}]
 */
Ext.define('Fes.model.Node', {
    extend: 'Ext.data.Model',
	fields : [{name : "id",type : "string"},
			{name : "text",type : "string"},
			{name : "iconCls",type : "string"},
			{name : "leaf",type : "boolean"},
			{name : 'type'},
			{name : 'component'}]
});
