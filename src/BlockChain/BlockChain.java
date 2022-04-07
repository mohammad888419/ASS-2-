/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BlockChain;

import block.chain.block;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mohammad
 */
public class BlockChain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        List<block> blockChainList = new ArrayList<>();

        block genesis = new block("BlockChain", 0);


        blockChainList.add(genesis);
        block helloBlock = new block("Hello", blockChainList.get(blockChainList.size() - 1).getHash());
        blockChainList.add(helloBlock);
        block worldBlock = new block("World", blockChainList.get(blockChainList.size() - 1).getHash());
        blockChainList.add(worldBlock);
        
        

  block v = new block("v", blockChainList.get(blockChainList.size() - 1).getHash());
       blockChainList.add(worldBlock);

        System.out.println("- BlockChain -");
        System.out.println("Hash helloBlock" + helloBlock.getHash());
        System.out.println("PreviousHash WorldBlock" + worldBlock.getPreviousHash());
        System.out.println("Is valid?: " + validate(blockChainList));

        block hiBlock = new block("Hi", genesis.getHash());
        int index = blockChainList.indexOf(helloBlock);
        blockChainList.remove(index);
        blockChainList.add(index, hiBlock);

        System.out.println("Corrupted block chain by replacing 'Hello' block with 'Hi' Block");
        System.out.println("- BlockChain -");
        System.out.println("Hash hiBlock" + hiBlock.getHash());
        System.out.println("PreviousHash WorldBlock" + worldBlock.getPreviousHash());

        System.out.println("Is valid?: " + validate(blockChainList));
    }

    private static boolean validate(List<block> blockChain) {

        boolean result = true;
        block lastBlock = null;
        for (int i = blockChain.size() - 1; i >= 0; i--) {
            if (lastBlock == null) {
                lastBlock = blockChain.get(i);
            } else {
                block current = blockChain.get(i);
                if (lastBlock.getPreviousHash() != current.getHash()) {
                    result = false;
                    break;
                }
                lastBlock = current;
            }
        }
        return result;
    }
}
