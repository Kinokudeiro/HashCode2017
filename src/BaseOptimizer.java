import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by usuario on 23/02/2017.
 */
public class BaseOptimizer {

    Integer[] cache_space;
    int cache_size;
    public BaseOptimizer(int cache_size, int num_caches) {
        this.cache_space = new Integer[num_caches];
        this.cache_size = cache_size;
        Arrays.fill(cache_space, cache_size);
    }
    public boolean getRandomBoolean() {
        return Math.random() < 0.8;
        //I tried another approaches here, still the same result

    }
    public void optimize(Integer[] video_size_list){
        Integer[] hola = new Integer[10];
        ArrayList<Integer>[] cache_videos = new ArrayList[this.cache_space.length];
        for(int v=0; v < cache_videos.length; v ++ ){
            cache_videos[v] = new ArrayList<Integer>();
        }
        int caches_used = 0;
        for (int i = 0; i < video_size_list.length; i++) {
            if (getRandomBoolean()) {
                int cache_index = 0;
                boolean found = false;
                while (!found && cache_index < cache_space.length) {
                    if (cache_space[cache_index] > video_size_list[i]) {
                        if (cache_space[cache_index] == cache_size) {
                            caches_used++;
                        }
                        cache_videos[cache_index].add(i);
                        cache_space[cache_index] -= video_size_list[i];
                        found = true;
                    } else {
                        cache_index++;
                    }
                }
            }
        }
        System.out.println(caches_used);
        for (int i =0; i < caches_used; i++){
            System.out.print(i);
            for (int j = 0; j < cache_videos[i].size(); j++) {
                System.out.print(" " + cache_videos[i].get(j));
            }
            System.out.println();

        }
    }

}
