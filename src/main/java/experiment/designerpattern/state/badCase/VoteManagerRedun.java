package experiment.designerpattern.state.badCase;

import java.util.HashMap;
import java.util.Map;

/**
 * 一个用户只能投一票
 * 一个用户投票次数超过5次,->恶意刷票->取消他的投票
 * 一个用户投票次数超过8次->黑名单->禁止登陆
 */
public class VoteManagerRedun {
    //用户名称-投票选项
    private Map<String, String> mapUserVote = new HashMap<>();

    //用户名-投票次数
    private Map<String, Integer> mapUserCount = new HashMap<>();

    /**
     * 投票
     *
     * @param user
     * @param voteItem
     */
    public void vote(String user, String voteItem) {
        Integer oldVoteCount = mapUserCount.get(user);
        if (oldVoteCount == null) {
            oldVoteCount = 0;
        }
        oldVoteCount += 1;
        mapUserCount.put(user, oldVoteCount);
        //2.判断用户的投票类型,正常//恶意/黑名单
        if (oldVoteCount == 1) {
            mapUserVote.put(user, voteItem);
        } else if (oldVoteCount > 1 && oldVoteCount < 5) {
            System.out.println("请勿重复投票");
        } else if (oldVoteCount >= 5 && oldVoteCount < 8) {
            //恶意投票

        } else if (oldVoteCount >= 8) {
            //黑名单

        }

    }


}
