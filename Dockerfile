FROM openjdk:11
RUN addgroup --system rmon && adduser --system rmon --ingroup rmon
USER rmon:rmon
ARG DEPENDENCY=target/dependency
COPY ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY ${DEPENDENCY}/META-INF /app/META-INF
COPY ${DEPENDENCY}/BOOT-INF/classes /app
ENTRYPOINT ["java","-cp","app:app/lib/*","com.rmon.ci_system.CiSystemApplication"]