/*
This file is part of Ext JS 4.2

Copyright (c) 2011-2013 Sencha Inc

Contact:  http://www.sencha.com/contact

GNU General Public License Usage
This file may be used under the terms of the GNU General Public License version 3.0 as
published by the Free Software Foundation and appearing in the file LICENSE included in the
packaging of this file.

Please review the following information to ensure the GNU General Public License version 3.0
requirements will be met: http://www.gnu.org/copyleft/gpl.html.

If you are unsure which license is appropriate for your use, please contact the sales department
at http://www.sencha.com/contact.

Build date: 2013-05-16 14:36:50 (f9be68accb407158ba2b1be2c226a6ce1f649314)
*/
/**
 * This is a utility class for being able to track all items of a particular type
 * inside any level at a container. This can be used in favour of bubbling add/remove events
 * which can add a large perf cost when implemented globally
 * @private
 */
Ext.define('Ext.container.Monitor', {
    target: null,
    selector: '',
    
    scope: null,
    addHandler: null,
    removeHandler: null,
    
    disabled: 0,
    
    constructor: function(config){
        Ext.apply(this, config);
    },
    
    bind: function(target){
        var me = this;
        
        me.target = target;
        target.on('beforedestroy', me.disable, me);
        me.onContainerAdd(target);
    },
    
    unbind: function() {
        var me = this,
            target = me.target;
            
        if (target) {
            target.un('beforedestroy', me.disable, me);
        }
        me.items = null;
    },
    
    disable: function(){
        ++this.disabled;    
    },
    
    enable: function(){
        if (this.disabled > 0) {
            --this.disabled;
        }
    },
    
    handleAdd: function(ct, comp) {
        if (!this.disabled) {
            if (comp.is(this.selector)) {
                this.onItemAdd(comp.ownerCt, comp);
            }
        
            if (comp.isQueryable) {
                this.onCon                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           me.onItemRemove(ct, comp);
            }
        
            if (comp.isQueryable) {
                me.onContainerRemove(ct, comp);
            }
        }
    },
    
    onContainerRemove: function(ct, comp){
        var me = this,
            items, i, len, item;
            
        // If it's not a container, it means it's a queryable that isn't a container.
        // For example a button with a menu
        if (!comp.isDestroyed && !comp.destroying && comp.isContainer) {
            me.removeCtListeners(comp);
            
            items = comp.query(me.selector);
            for (i = 0, len = items.length; i < len; ++i) {
                item = items[i];
                me.onItemRemove(item.ownerCt, item);
            }
            
            items = comp.query('container');
            for (i = 0, len = items.length; i < len; ++i) {
                me.removeCtListeners(items[i]);
            }
        } else {
            // comp destroying, or we need to invalidate the collection
            me.invalidateItems();
        }
    },
    
    removeCtListeners: function(comp){
        var me = this;
        comp.un('add', me.handleAdd, me);
        comp.un('dockedadd', me.handleAdd, me);
        comp.un('remove', me.handleRemove, me);
        comp.un('dockedremove', me.handleRemove, me);
    },
    
    getItems: function(){
        var me = this,
            items = me.items;
            
        if (!items) {
            items = me.items = new Ext.util.MixedCollection();
            items.addAll(me.target.query(me.selector));
        }
        return items;
    },
    
    invalidateItems: function(){
        this.items = null;
    }
});
