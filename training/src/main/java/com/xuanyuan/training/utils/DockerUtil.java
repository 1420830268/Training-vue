package com.xuanyuan.training.utils;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.command.DockerCmdExecFactory;
import com.github.dockerjava.core.DefaultDockerClientConfig;
import com.github.dockerjava.core.DockerClientBuilder;
import com.github.dockerjava.core.DockerClientConfig;
import com.github.dockerjava.jaxrs.JerseyDockerCmdExecFactory;

/**
 * @ClassName DockerUtil
 * @Desctiption : TODO
 * @Author Lee
 * @Date 2020/4/1 15:37
 */
public class DockerUtil {

    public static DockerClient getDockerClient(String hostIp,int port,String path) throws Exception {
        DockerClient dockerClient = null;
        if (dockerClient == null){
            synchronized (DockerUtil.class){
                DockerClientConfig config = DefaultDockerClientConfig.createDefaultConfigBuilder().withDockerTlsVerify(true)
                        .withDockerCertPath(path).withDockerHost("tcp://"+hostIp+":"+port)
                        .withDockerConfig(path)
                        .build();
                //  .withApiVersion("1.38")
                // .withRegistryUrl("https://192.168.103.235/harbor/")
                // .withRegistryUsername("admin").withRegistryPassword("Harbor12345")
                // .withRegistryEmail("dockeruser@github.com").build();
                DockerCmdExecFactory dockerCmdExecFactory =  new JerseyDockerCmdExecFactory()
                        .withReadTimeout(1000)
                        .withConnectTimeout(1000)
                        .withMaxTotalConnections(100)
                        .withMaxPerRouteConnections(10);
                dockerClient = DockerClientBuilder.getInstance(config).withDockerCmdExecFactory(dockerCmdExecFactory).build();
            }
        }
        return dockerClient;
    }

    public static void main(String[] args) {
        try {
            String hostIp="192.168.103.238";
            int port=2375;
            String path="C:\\Users\\Laughing\\Desktop\\cert\\";
            DockerClient dc=getDockerClient(hostIp,port,path);
            //查询info
//            Info info=dc.infoCmd().exec();
//            List<Image> list2=dc.listImagesCmd().exec();
//            System.out.println(info);

              dc.pullImageCmd("");


            dc.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}