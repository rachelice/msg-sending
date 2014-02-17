Ext.define("Fes.util.ComboTree", {
	extend : "Ext.form.field.Picker",
	alias : 'widget.comboTree',
    requires : ["Ext.tree.Panel"],  
    _idValue : '',  
    initComponent : function() {  
      this.callParent();
      this.creatTree();
  
    },
    creatTree : function(){
        var self = this;  
        var store = Ext.create('Ext.data.TreeStore',{
                proxy : {  
                    type : 'ajax',  
                    url : self.storeUrl
               },  
               nodeParam: 'id',
               root : {  
                   id : self.rootId,  
                   text : self.rootText,
                   expanded : self.expanded
               }
        });
        self.picker = new Ext.tree.Panel({
               id:Ext.id(),              
               height : self.treeHeight||300,  
               resizable:true,minWidth:100,maxWidth:400,minHeight:200,maxHeight:500,  
               autoScroll : true,  
               floating : true,  
               focusOnToFront : false,  
               shadow : true,  
               ownerCt : this.ownerCt,  
               useArrows : self.useArrows||true,  
               store : store,  
               rootVisible : self.rootVisible 
        });  
        self.picker.on({
      	  checkchange : function() {
      		    var records = self.picker.getView().getChecked(), names = [], values = [];
      		    Ext.Array.each(records, function(rec) {
      		       names.push(rec.get('text'));
      		       values.push(rec.get('id'));
      		      });
      		    self.setRawValue(values.join(','));// 隐藏值
      		    self.setValue(names.join(','));// 显示值
      		    self._idValue=values.join(',');
      		    //alert(values.join(','));
      		  //self.fireEvent('select',self,rec);
      		    
      	  }
        });
    },
    getIdValue : function(){//获取id值  
        return this._idValue;  
    }, 
    reLoad:function(id,url){  
        var store=this.picker.getStore();  
        var root=this.picker.getRootNode();  
        store.proxy.url =url;  
        root.set('id',id);  
        store.load();  
    },  
    alignPicker : function() {  
      var me = this, picker, isAbove, aboveSfx = '-above';  
      if (this.isExpanded) {  
           picker = me.getPicker();  
           if (me.matchFieldWidth) {  
              picker.setWidth(me.bodyEl.getWidth());  
           }  
           if (picker.isFloating()) {  
               picker.alignTo(me.inputEl, "", me.pickerOffset);  
               isAbove = picker.el.getY() < me.inputEl.getY();  
               me.bodyEl[isAbove ? 'addCls' : 'removeCls'](me.openCls+ aboveSfx);  
               picker.el[isAbove ? 'addCls' : 'removeCls'](picker.baseCls+ aboveSfx);  
           }  
      }  
    }  
});