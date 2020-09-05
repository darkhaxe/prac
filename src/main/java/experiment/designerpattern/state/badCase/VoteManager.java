package experiment.designerpattern.state.badCase;

import java.util.HashMap;
import java.util.Map;

public class VoteManager {

    //用户名称-投票选项
    private Map<String, String> mapUserVote = new HashMap<>();

    //用户名-投票次数
    private Map<String, Integer> mapUserCount = new HashMap<>();
    /*
        状态处理对象
     */
    private VoteState state = null;


    public void vote(String user, String voteItem) {
        Integer count = mapUserCount.get(user);
        if (count == null) {
            count = 0;
        }
        count += 1;
        mapUserCount.put(user, count);

        //判断投票类型对应的状态
        if (count == 1) {
            state = new NormalVoteState();
        } else if (count > 1 && count < 5) {
            state = new RepeatVoteState();
        } else if (count >= 5 && count < 8) {
            state = new SpiteVoteState();
        } else if (count >= 8) {
            state = new BlockListVoteState();
        }
        //状态处理类执行业务逻辑
        state.vote(user, voteItem, this);
    }

    private class NormalVoteState implements VoteState {
        @Override
        public void vote(String user, String voteItem, VoteManager voteManager) {

        }
    }

    private class RepeatVoteState implements VoteState {
        @Override
        public void vote(String user, String voteItem, VoteManager voteManager) {

        }
    }

    private class SpiteVoteState implements VoteState {
        @Override
        public void vote(String user, String voteItem, VoteManager voteManager) {

        }
    }

    private class BlockListVoteState implements VoteState {
        @Override
        public void vote(String user, String voteItem, VoteManager voteManager) {

        }
    }
}
