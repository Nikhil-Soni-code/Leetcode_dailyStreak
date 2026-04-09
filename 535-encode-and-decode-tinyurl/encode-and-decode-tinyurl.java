public class Codec {
    String base = "https://jaishreeram//";
    int count = 1;
    HashMap<String,String> db = new HashMap();
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String newUrl = base+count;
        db.put(newUrl,longUrl);
        count++;
        return newUrl;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        String ans = db.get(shortUrl);
        
        return ans; 

    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));