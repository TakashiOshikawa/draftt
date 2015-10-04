import System.Process

main = do
        print "param: e_mail"
        mail <- getLine
        print "param: password"
        pass <- getLine
        let curlCmd = "curl 127.0.0.1:8023/student/signup -X POST -d \"e_mail=" ++ mail ++ "&password=" ++ pass ++ "\""
        system curlCmd

