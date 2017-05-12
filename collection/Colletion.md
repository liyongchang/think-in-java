#List    
     ordered and indexed collection which may contain duplicates
`ArrayList and LinkedList  Vector`
#Set     
    un-ordered collection of unique objects
` [LinkedHashSet, TreeSet and HashSet`
#Map
     data structure based on key value pair and hashing
`HashMap 
 Hashtable
 Hashtable doesn't allow null key or values but HashMap allows null values and one null keys. 
##阿里巴巴开发规范集合类想到的
###关于hashCode和equals的处理，遵循如下规则： 
* 只要重写equals，就必须重写hashCode。 
> 因为Set存储的是不重复的对象，依据hashCode和equals进行判断，所以Set存储的对象必须重写这两个方法。 
* 如果自定义对象做为Map的键，那么必须重写hashCode和equals。 
> 说明：String重写了hashCode和equals方法，所以我们可以非常愉快地使用String对象作为key来使用。