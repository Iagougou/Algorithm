/**
 * 布隆过滤器
 */
public class BloomFilter {

   private byte[] bits;

    /**
     * 初始化数组大小
     * @param size
     */
   public BloomFilter(int size){
       bits = new byte[size];
   }

    /**
     * 设置hash算法
     */
    private  int hash1(String str){
        return  str.hashCode();
    }
    private  int hash2(String str){
        int hash = 7;
        for (int i=0 ;i<str.length();i++){
            hash=hash*31+str.charAt(i);
        }
        return hash;
    }

    public void add(String value){
        int hash1 = hash1(value);
        int hash2 = hash2(value);
        bits[hash1%bits.length]=1;
        bits[hash2%bits.length]=1;
    }

    public boolean contains(String value){
        int hash1 = hash1(value);
        int hash2 = hash2(value);
        return bits[hash1%bits.length]==1 &&
                bits[hash2%bits.length]==1;
    }

    public static void main(String[] args) {
        BloomFilter bloomFilter = new BloomFilter(4);
        bloomFilter.add("jjj");
        bloomFilter.add("mmmm");
        bloomFilter.add("mmjj");
        System.out.printf(bloomFilter.contains("mqmjj")+"");
    }
}



