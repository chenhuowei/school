Ext.form.ComboBox.prototype.setValue = function(v){
	
    if(v != null && v['value'] != null && v["text"] != null){
        if(this.mode === 'remote'){
            var _record = new (this.getStore().recordType)();
            _record.set("value",v["value"]);
            _record.set("text",v["text"]);
            this.getStore().add(_record);
            this.setValue(v["value"]);
        }
        else{
            Ext.form.ComboBox.superclass.setValue.call(this, v["text"]);
            if(this.hiddenField){
                this.hiddenField.value = Ext.value(v["value"], '');
            }
            this.value = v["value"];
        }
    }
    else{
        var text = v;
        if(this.valueField){
            var r = this.findRecord(this.valueField, v);
            if(r){
                text = r.data[this.displayField];
            }else if(Ext.isDefined(this.valueNotFoundText)){
                text = this.valueNotFoundText;
            }
        }
        this.lastSelectionText = text;
        if(this.hiddenField){
            this.hiddenField.value = Ext.value(v, '');
        }
        Ext.form.ComboBox.superclass.setValue.call(this, text);
        this.value = v;
        
    }
    
    return this;
};

            //----------------------继承了CheckboxGroup使其能够取 remote 数据源开始----------------------//
            Ext.namespace("Ext.ux");
            Ext.ux.RemoteCheckboxGroup = Ext.extend(Ext.form.CheckboxGroup, {
                url: '',
                boxLabel: '',
                inputValue: '',
                setValue: function (val) {
                    if (val.split) {
                        val = val.split(',');
                    }
                    this.reset();
                    for (var i = 0; i < val.length; i++) {
                        this.items.each(function (c) {
                            if (c.inputValue == val[i]) {
                                c.setValue(true);
                            }
                        });
                    }
                },
                reset: function () {
                    this.items.each(function (c) {
                        c.setValue(false);
                    });
                },
                getValue: function () {
                    var val = [];
                    this.items.each(function (c) {
                        if (c.getValue() == true)
                            val.push(c.inputValue);
                    });
                    return val.join(',');
                },
                initComponent: function (ct, position) {
                    var items = [];
                    if (!this.items) { //如果没有指定就从URL获取
                        Ext.Ajax.request({
                            url: this.url,
                            scope: this,
                            async: false,
                            success: function (response) {
                                var data = Ext.util.JSON.decode(response.responseText);
                               
                                var Items2 = this.items;
                                if (this.panel) {
                                    var columns = this.panel.items;
                                    if (columns) {
                                        for (var i = 0; i < columns.items.length; i++) {
                                            column = columns.items[i];
                                            column.removeAll();
                                        }
                                        Items2.clear();
                                    }
                                }
                                for (var i = 0; i < data.length; i++) {
                                    var d = data[i];
                                    var chk = { boxLabel: d[this.boxLabel], name: this.name, inputValue: d[this.inputValue] };
                                    items.push(chk);
                                }
                            }
                        });
                        this.items = items;
                    }
                    Ext.ux.RemoteCheckboxGroup.superclass.initComponent.call(this, ct, position);
                }
            });
         // Ext.define('remotecheckboxgroup', Ext.ux.RemoteCheckboxGroup);
            //----------------------继承了CheckboxGroup使其能够取 remote 数据源结束----------------------//
         














