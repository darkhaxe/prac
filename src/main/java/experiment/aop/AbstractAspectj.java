package experiment.aop;

import com.alibaba.fastjson.JSON;
import experiment.exception.BusinessException;
import com.google.common.collect.Lists;
import org.codehaus.plexus.util.ExceptionUtils;
import org.jetbrains.annotations.NotNull;

import java.lang.reflect.UndeclaredThrowableException;
import java.util.List;


public abstract class AbstractAspectj {


    protected static String br = "<br>";

    //转换环境描述信息
    @NotNull
    public static String convertEnvDesc(int appEnv) {
        switch (appEnv) {
            case 0:
                return "个人环境";
            case 1:
                return "开发环境";
            case 2:
                return "测试环境";
            case 3:
                return "仿真环境";
            case 4:
                return "正式环境";
            default:
                return "未知环境参数：" + appEnv;
        }
    }

    //获取异常堆栈信息
    protected String getStackTrace(Exception e) {
        return ExceptionUtils.getFullStackTrace(e);
    }

    //参数转为字符串
    @NotNull
    protected String conventTOStr(@NotNull Object[] objects) {
        List<String> params = Lists.newArrayList();

        for (Object object : objects) {
            if (object instanceof String) {
                params.add((String) object);
            } else {
                try {
                    params.add(JSON.toJSONString(object));
                } catch (Exception ignore) {
                    params.add(object.toString());
                }
            }
        }
        return params.toString();
    }

    //验证异常
    protected boolean verifyExceptionType(Exception ex) {
        if (ex instanceof BusinessException) {
            return false;
        } else if (ex instanceof UndeclaredThrowableException) {
            try {
                if (ex.getCause().getCause() instanceof BusinessException) {
                    return false;
                }
            } catch (Exception ignore) {
                return true;
            }
        }
        return true;
    }

}
