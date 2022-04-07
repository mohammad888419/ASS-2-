/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package block.chain;

import java.util.Arrays;

/**
 *
 * @author Mohammad
 */
public class block {
    private int previousHash;
    private String data;
    private int hash;
    
    public block(String data, int previousHash) {
        this.data = data;
        this.previousHash = previousHash;
        this.hash  = Arrays.hashCode(new Integer[]{data.hashCode(), previousHash});
    }

    public int getPreviousHash() {
        return previousHash;
    }

    public void setPreviousHash(int previousHash) {
        this.previousHash = previousHash;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getHash() {
        return hash;
    }

    public void setHash(int hash) {
        this.hash = hash;
    }
    
}
