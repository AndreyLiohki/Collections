package org.example;

import java.lang.reflect.Array;

public class CArrayList<T> {
    private int size;
    private T[] arr;
    private int index = 0;

    @SuppressWarnings("unchecked")
   public CArrayList(Class<T> type){
        this.size = 1;
        this.arr = (T[]) Array.newInstance(type, this.size);
    }

    @SuppressWarnings("unchecked")
    public CArrayList(Class<T> type, int size){
        this.size = size;
        this.arr = (T[]) Array.newInstance(type, this.size);
    }

    @SuppressWarnings("unchecked")
    public CArrayList(Class<T> type, int size, T value){
        this.size = size;
        this.index = size;
        this.arr = (T[]) Array.newInstance(type, this.size);
        for(int i = 0; i < size; ++i){
            this.arr[i] = value;
        }
    }

    public void put(T value, int index){
        if(index<0 || index >=this.size){
            throw new ArrayIndexOutOfBoundsException("CArrayList index is out of range: " + index);
        }
        this.arr[index] = value;
    }

    public T get(int index){
        if(index<0 || index >=this.size){
            throw new ArrayIndexOutOfBoundsException("CArrayList index is out of range: " + index);
        }
        return this.arr[index];
    }

    public void push(T value){
        if(this.index >= this.size){

            @SuppressWarnings("unchecked")
            T[] newArray = (T[]) Array.newInstance(arr.getClass().getComponentType(), 2*this.size);

            for(int i = 0; i < this.size; ++i){
                newArray[i] = this.arr[i];
            }
            this.arr = newArray;
            this.size+=1;
        }
        this.arr[this.index] = value;
        this.index++;
    }

    public void delete(int index){
        if(index < 0 || index >=this.size){
            throw new ArrayIndexOutOfBoundsException("CArrayList index is out of range: " + index);
        }

    }

    public int arraySize(){
        return this.size;
    }
}
