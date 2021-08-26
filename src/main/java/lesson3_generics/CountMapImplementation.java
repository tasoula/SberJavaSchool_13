package lesson3_generics;

import java.util.*;

/**
 * Created by Настя on 23.08.2021.
 */
public class CountMapImplementation<T> implements CountMap<T> {

    HashMap<T, Integer> list = new HashMap<>();

    @Override
    public void add(T o){
        //list.add(o);
        list.put(o, list.containsKey(o) ? list.get(o) + 1 : 1);
    }

    @Override
    public int getCount(T o){
       /* int count = 0;
        for(T t : list){
            if(t.equals((o))) count++;
        }
        return count;*/
        return list.get(o);
    }

    @Override
    public int remove(T o){
        /*int count = 0;
        Iterator<T> iterator = list.iterator();
        while(iterator.hasNext()) {
            T nextT = iterator.next();
            if(nextT.equals(o)) {
                count++;
                if(count == 0) iterator.remove();
            }
        }
        return count;*/

        return list.remove(o);
    }

    @Override
    public int size(){
       /* HashSet<T> set = new HashSet<>();
        set.addAll(list);
        return set.size();*/
        return list.size();
    }

    @Override
    public void addAll(CountMap<T> source){
        Map<T, Integer> sourceMap = source.toMap();
        for(Map.Entry<T, Integer> entry : sourceMap.entrySet()) {
            T key = entry.getKey();
            Integer thisCount = list.get(key);
            if(thisCount==null)
                list.put(key, entry.getValue());
            else {
                list.put(key , entry.getValue() + thisCount);
            }

            // do what you have to do here
            // In your case, another loop.
        }
    }

    @Override
    public Map<T,Integer> toMap(){
       /* HashMap<T, Integer> map = new HashMap<>();
        list.forEach(t-> map.put(t, map.containsKey(t) ? map.get(t) + 1 : 1));
        return map;*/
        return list;
    }

    @Override
    public void toMap(Map<T,Integer> destination){
        //list.forEach(t-> destination.put(t, destination.containsKey(t) ? destination.get(t) + 1 : 1));
        destination.putAll(list);
    }
}
