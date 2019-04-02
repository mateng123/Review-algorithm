public class Array <E>{

    private E[] data;
    private int size;

    /**
     * 构造函数，传入数组的容量capacity构造Array
     * @param capacity
     */
    public Array(int capacity){
        data = (E[]) new Object[capacity];
        size = 0;
    }

    public Array(){
        this(10);
    }

    //获取数组中元素的个数
    public int getSize(){
        return size;
    }

    //获取数组的容量
    public int getCapacity(){
        return data.length;
    }

    //返回数组是否为空
    public boolean isEmpty(){
        return size ==0;
    }

    //向所有元素后添加一个新元素
    public void addLast(E e){
        add(size,e);
    }
    //向所有元素前添加一个新元素
    public void addFirst(E e){
        add(0,e);
    }

    //在index个位置上插入一个新元素e
    public void add(int index,E e){

        if(index<0||index>size){
            throw new IllegalArgumentException("AddLast failed. Array is already full");
        }

        if(size==data.length)
            resize(2*data.length);

        for (int i=size-1;i>=index;i--){
            data[i+1] = data[i];
        }
        data[index] = e;
        size++;
    }

    //获取index索引位置的元素
    public E get(int index){
        if(index<0||index>=size){
            throw new IllegalArgumentException("get failed , index is illegal");
        }
        return data[index];
    }

    public E getLast(){
        return get(size-1);
    }

    public E getFirst(){
        return get(0);
    }

    //修改index索引位置的元素e
    public void set(int index, E e){
        if(index<0||index>=size){
            throw new IllegalArgumentException("get failed , index is illegal");
        }
        data[index] = e;
    }

    public boolean contains(E e){
        for (int i=0;i<size;i++){
            if (data[i].equals(e)){
                return true;
            }
        }
        return false;
    }

    //查找数组中元素e的索引，如果没找到则返回-1
    public int find(E e){
        for (int i=0;i<size;i++){
            if (data[i].equals(e)){
                return i;
            }
        }
        return -1;
    }

    //删除指定位置的索引
    public E remove(int index) {
        if (index<0||index>=size) {throw new IllegalArgumentException("index is illegal");}
        E ret=data[index];
        for (int i=index;i<size-1;i++){
            data[i]=data[i+1];
        }
        size--;
        data[size]=null;

        if (size == data.length/4 &&data.length/2 != 0){
            resize(data.length/2);
        }

        return ret;
    }

    //删除第一个元素
    public E removeFirst(){
        return remove(0);
    }

    //删除最后一个元素
    public E removeLast(){
        return remove(size-1);
    }

    //删除指定元素
    public void  removeElement(E e){
        int index = find(e);
        if (index != -1){
            remove(index);
        }
    }

    @Override
    public String toString(){

        StringBuilder res = new StringBuilder();
        res.append(String.format("Array : size = %d,capacity = %d\n",size,data.length));
        res.append('[');
        for (int i =0;i<size;i++){
            res.append(data[i]);
            if (i != size-1){
                res.append(", ");
            }

        }
        res.append(']');
        return res.toString();
    }

    private void resize(int newCapacity){
        E[] newData = (E[])new Object[newCapacity];
        for (int i =0;i<size;i++){
            newData[i] = data[i];
        }
        data = newData;
    }
}
